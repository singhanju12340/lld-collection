package com.machineCode.lld.wayfair;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class DistanceBetweenBuilding {



    public static boolean isBuildingPatternPresent(List<Integer> buildingHeights, int K) {
        Map<Integer, Integer> heightMap = new HashMap<>();




        for(int i=0;i<buildingHeights.size();i++){
            if(heightMap.containsKey(buildingHeights.get(i))){
                Integer lastOccurance =  heightMap.get(buildingHeights.get(i));
                Integer currentCoounrance = i;

                if(currentCoounrance-lastOccurance <=K){
                    System.out.println("currentCoounrance : currentCoounrance " + currentCoounrance  +" : "+ lastOccurance + " for "+ buildingHeights.get(i));
                    return true;

                }else{
                    heightMap.put(buildingHeights.get(i), i);
                }
            }else{
                heightMap.put(buildingHeights.get(i), i);
            }
        }

        return false;

    }

    public static boolean isBuildingPatterenAlmostSameHeightPresent(List<Integer> buildingHeights, int K, int maxHeightDiff) {

        // check for each window size
        //  check for any home of matching criteria within the window
        // return true
        // else go till end

        for(int i=K;i<buildingHeights.size(); i++){
            for(int j=i-K;j<=i ;j++){
                Integer prevHeight = buildingHeights.get(j);
                Integer currHeight = buildingHeights.get(i);
                if(Math.abs(currHeight - prevHeight) <= maxHeightDiff){
                    return true;
                }
            }
        }

        return false;

    }


    // optimised soultion
    public boolean hasNearbyHouses(int[] heights, int k, int M) {
        if (k <= 0 || M < 0) return false;

        TreeSet<Integer> window = new TreeSet<>();

        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];

            // Check if there's a height in the window within [currentHeight - M, currentHeight + M]
            Integer floor = window.floor(currentHeight + M);
            Integer ceiling = window.ceiling(currentHeight - M);

            if ((floor != null && floor >= currentHeight - M) ||
                    (ceiling != null && ceiling <= currentHeight + M)) {
                return true;
            }

            window.add(currentHeight);

            // Maintain window size <= k
            if (i >= k) {
                window.remove(heights[i - k]);
            }
        }
        return false;
    }




    public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int buildingHeightsCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> buildingHeights = IntStream.range(0, buildingHeightsCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            int K = Integer.parseInt(bufferedReader.readLine().trim());

            boolean result = DistanceBetweenBuilding.isBuildingPatternPresent(buildingHeights, K);

            bufferedWriter.write(String.valueOf(result ? 1 : 0));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();

    }



}
