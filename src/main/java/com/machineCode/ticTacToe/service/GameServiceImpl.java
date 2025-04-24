package com.machineCode.ticTacToe.service;

import com.machineCode.ticTacToe.dto.GameDto;
import com.machineCode.ticTacToe.dto.UserDto;

/**
 * @author anju
 * @created on 17/04/25 and 8:58 PM
 */
public class GameServiceImpl implements GameService{
    UserDto userDto;
    GameDto gameDto;

    @Override
    public void initGame() {

    }

    @Override
    public void addPlayer() {
        userDto.addUser();
    }
}
