package com.machineCode.application.influxDb;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;

import java.time.Instant;
import java.util.List;

/**
 * @author anju
 * @created on 23/02/25 and 10:27 PM
 */
public class SaveDataInfluxByAPI {
    private static final String INFLUX_URL = "http://localhost:8086";
    private static final String TOKEN = "ifTJVazRM5Mhg-OcxLUVPTa-yzQsU0aLh8ESLM7FeuePZl43a-jWFk3Hy774BJ2LVYwoDt6XMaNuP6aeKueQ1w==";
    private static final String ORG = "influx-explorler";
    private static final String BUCKET = "uber";

    public static void main(String[] args) {
//        InfluxDB influxDB = InfluxDBFactory.connect(INFLUX_URL, "anju", "angel.00");
        InfluxDBClient client = InfluxDBClientFactory.create(INFLUX_URL, TOKEN.toCharArray(), ORG, BUCKET);



        try {
            // Write a sample point representing a driver's location update.
            WriteApiBlocking writeApi = client.getWriteApiBlocking();
            Point point = Point.measurement("driver_location")
                    .addTag("driverId", "driver123")
                    .addField("latitude", 37.7749)
                    .addField("longitude", -122.4194)
                    .addField("speed", 45)
                    .time(Instant.now().toEpochMilli(), WritePrecision.NS);

            writeApi.writePoint(point);
            System.out.println("Driver location point written to InfluxDB.");

            // Query recent location updates for a specific driver using Flux query language.
            QueryApi queryApi = client.getQueryApi();
            String fluxQuery = String.format(
                    "from(bucket: \"%s\") " +
                            "|> range(start: -10m) " +
                            "|> filter(fn: (r) => r._measurement == \"driver_location\" and r.driverId == \"%s\") " +
                            "|> sort(columns: [\"_time\"], desc: true) " +
                            "|> limit(n: 5)",
                    BUCKET, "driver123"
            );

            List<FluxTable> tables = queryApi.query(fluxQuery);
            System.out.println("Recent location updates for driver123:");
            for (FluxTable table : tables) {
                for (FluxRecord record : table.getRecords()) {
                    System.out.println(record);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the client to free resources.
            client.close();
        }




    }
}
