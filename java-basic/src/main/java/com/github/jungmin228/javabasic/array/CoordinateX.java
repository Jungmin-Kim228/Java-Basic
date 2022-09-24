package com.github.jungmin228.javabasic.array;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * 지뢰찾기(10x10)
 * true 가 지뢰, false 가 통과
 *
 * 1
 * @author Jungmin228
 */
@Slf4j
@NoArgsConstructor
@Getter
public class CoordinateX {

    private static final int SIZE = 10;

    private int x;
    private int y;

    private char[][] board = new char[SIZE][SIZE];
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

    public void run() {
        this.setBoard();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("좌표 입력(종료=0 0): ");
            String input = scanner.nextLine();

            if (input.length() != 3)
                throw new RuntimeException("Input Size Invalid: " + input.length());

            this.x = Integer.parseInt(input.split(" ")[0]);
            this.y = Integer.parseInt(input.split(" ")[1]);

            System.out.println(x + " " + y);
            return;
        }

    }

    private void setBoard() {
        for (int i = 1; i < SIZE; i++) {
            this.board[i][0] = this.board[0][i] = (char) (i + '0');
        }
    }

}
