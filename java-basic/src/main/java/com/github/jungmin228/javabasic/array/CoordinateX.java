package com.github.jungmin228.javabasic.array;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * 지뢰찾기(10x10)
 * true 가 지뢰, false 가 통과
 * <p>
 * 1
 *
 * @author Jungmin228
 */
@Slf4j
@NoArgsConstructor
@Getter
public class CoordinateX {

    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 10;

    private int x;
    private int y;

    private char[][] board = new char[MAX_SIZE][MAX_SIZE];
    private boolean[][] shipBoard = {
            { false, false, true, false, false, false, false, false, false },
            { false, false, true, false, false, false, false, true, false },
            { false, false, true, false, false, false, true, false, false },
            { true, false, false, false, false, false, false, false, false },
            { true, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, true, false, false, false },
            { false, true, false, true, false, false, false, false, false },
            { false, false, false, false, false, false, false, true, false },
            };

    /**
     * 지뢰찾기 실행
     */
    public void run() {
        this.setBoard();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input coordinate.(exit=0 0): ");
            String input = scanner.nextLine();

            initXY(input);

            if (x == 0 && y == 0) {
                break;
            }

            if (!validateXY(x, y)) {
                System.out.println("Invalid x, y. Input again.");
                continue;
            }

            board[x][y] = shipBoard[x-1][y-1] ? 'O' : 'X';

            printBoard();

        }
        System.out.println("Game over.");
    }

    /**
     * 행, 열 번호 저장
     */
    private void setBoard() {
        this.board[MIN_SIZE][MIN_SIZE] = ' ';

        for (int i = MIN_SIZE+1; i < MAX_SIZE; i++) {
            this.board[i][MIN_SIZE] = this.board[MIN_SIZE][i] = (char) (i + '0');
        }

        for (int j = MIN_SIZE+1; j < MAX_SIZE; j++) {
            for (int k = MIN_SIZE+1; k < MAX_SIZE; k++) {
                this.board[j][k] = ' ';
            }
        }
    }

    private void printBoard() {
        for (int i = MIN_SIZE; i < MAX_SIZE; i++) {
            System.out.println(board[i]);
        }
    }

    /**
     * x, y 값 초기화
     * @param input 사용자 입력값
     */
    private void initXY(String input) {
        this.x = Integer.parseInt(input.split(" ")[0]);
        this.y = Integer.parseInt(input.split(" ")[1]);
    }

    /**
     * x, y 검사
     *
     * @param x x 좌표
     * @param y y 좌표
     * @return 유효한가 하지않은가 boolean 타입
     */
    private boolean validateXY(int x, int y) {
        if (x < MIN_SIZE || x >= MAX_SIZE || y < MIN_SIZE || y >= MAX_SIZE) {
            return false;
        }

        return true;
    }

}
