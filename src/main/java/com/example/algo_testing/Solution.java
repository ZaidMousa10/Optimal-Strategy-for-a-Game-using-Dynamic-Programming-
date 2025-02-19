package com.example.algo_testing;

/**
 * The Solution class solves the "Optimal Game Strategy" problem using Dynamic Programming.
 * It determines the maximum score a player can achieve by playing optimally and identifies the winner.
 */

public class Solution {
    private Integer[][] dpTable; // Dynamic Programming table to store problem solutions
    private Integer[] inputArray; // Input array of integers representing the values to be picked
    private String[] optimalMoves; // Array to store the moves made by the winning player
    private String winner; // The winner of the game ("Player 1" or "Player 2")

    /**
     * Solves the "Optimal Game Strategy" problem by filling the DP table.
     * Computes the maximum gain Player 1 can achieve.
     * Return the maximum gain for Player 1.
     */
    public int findMaxGain() {
        int n = inputArray.length;
        dpTable = new Integer[n][n];
        int pickLeftO= 0;
        int pickRightO= 0;

        // Initial value: When there is one coin
        for (int i = 0; i < n; i++) {
            dpTable[i][i] = inputArray[i];
        }
        // Initial value: When there are two coins
        for (int i = 0; i < n - 1; i++) {
            dpTable[i][i + 1] = Math.max(inputArray[i], inputArray[i + 1]);
        }
        // Fill the table for subarrays of length 2 to n
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                int pickLeft = inputArray[i] + Math.min((i + 2 <= j ? dpTable[i + 2][j] : 0),
                        (i + 1 <= j - 1 ? dpTable[i + 1][j - 1] : 0));
                int pickRight = inputArray[j] + Math.min((i <= j - 2 ? dpTable[i][j - 2] : 0),
                        (i + 1 <= j - 1 ? dpTable[i + 1][j - 1] : 0));

                dpTable[i][j] = Math.max(pickLeft, pickRight);
                pickLeftO=pickLeft;
                pickRightO=pickRight;
            }
        }

        String[] moves = new String[n]; // Combined moves for both players
        int moveIndex = 0;
        int scorePlayer1 = 0;
        int scorePlayer2 = 0;
        int i = 0, j = n - 1;
        boolean isPlayer1Turn = true;

        while (i <= j) {

            if (pickLeftO > pickRightO) {
                if (isPlayer1Turn) {
                    scorePlayer1 += inputArray[i];
                    moves[moveIndex++] = "Player 1 picks " + inputArray[i];
                } else {
                    scorePlayer2 += inputArray[i];
                    moves[moveIndex++] = "Player 2 picks " + inputArray[i];
                }
                i++;
            } else if (pickRightO > pickLeftO) {
                if (isPlayer1Turn) {
                    scorePlayer1 += inputArray[j];
                    moves[moveIndex++] = "Player 1 picks " + inputArray[j];
                } else {
                    scorePlayer2 += inputArray[j];
                    moves[moveIndex++] = "Player 2 picks " + inputArray[j];
                }
                j--;
            } else {
                if (isPlayer1Turn) {
                    if (inputArray[i] > inputArray[j]) {
                        scorePlayer1 += inputArray[i];
                        moves[moveIndex++] = "Player 1 picks " + inputArray[i];
                        i++;
                    } else {
                        scorePlayer1 += inputArray[j];
                        moves[moveIndex++] = "Player 1 picks " + inputArray[j];
                        j--;
                    }
                } else {
                    if (inputArray[i] > inputArray[j]) {
                        scorePlayer2 += inputArray[i];
                        moves[moveIndex++] = "Player 2 picks " + inputArray[i];
                        i++;
                    } else {
                        scorePlayer2 += inputArray[j];
                        moves[moveIndex++] = "Player 2 picks " + inputArray[j];
                        j--;
                    }
                }
            }
            isPlayer1Turn = !isPlayer1Turn;
        }

        // Determine the winner
        winner = (scorePlayer1 > scorePlayer2) ? "Player 1" : "Player 2";

        // Copy all moves to the optimalMoves array
        optimalMoves = new String[moveIndex];
        System.arraycopy(moves, 0, optimalMoves, 0, moveIndex);

        return dpTable[0][n - 1];
    }

    /**
     * Sets the input array and initializes the DP table to calculate the solution.
     * Elements the input array representing the values to be picked.
     */
    public void setDPTable(Integer[] elements) {
        this.inputArray = elements;
        findMaxGain();
    }
    // Return the input array.
    public Integer[] getInputArray() {
        return inputArray;
    }
    // Return the computed DP table.
    public Integer[][] getDPTable() {
        return dpTable;
    }
    // Return the optimal moves made by the winning player.
    public String[] getOptimalMoves() {
        return optimalMoves;
    }
    // Return the winner of the game ("Player 1" or "Player 2").
    public String getWinner() {
        return winner;
    }
    // Return the score of the winner optimally.
    public int getWinnerScore() {
        return dpTable[0][dpTable.length-1];
    }
}
