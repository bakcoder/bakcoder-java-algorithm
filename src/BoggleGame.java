public class BoggleGame {
    int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
    int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};
    String[][] board = {{"B", "W", "E", "R", "E"},
                        {"U", "V", "W", "B", "A"},
                        {"E", "A", "X", "Z", "K"},
                        {"A", "X", "T", "C", "O"},
                        {"W", "F", "R", "E", "D"}};

    String[][] resultBoard = {{".", ".", ".", ".", "."},
                              {".", ".", ".", ".", "."},
                              {".", ".", ".", ".", "."},
                              {".", ".", ".", ".", "."},
                              {".", ".", ".", ".", "."}};

    public static void main(String[] args) {
        String word = "BAKCODER";

        BoggleGame game = new BoggleGame();

        if(game.hasWord(1,3, word)) {
            for(int i=0 ; i<game.resultBoard.length ; i++) {
                for(int j=0 ; j<game.resultBoard[i].length ; j++) {
                    System.out.print(game.resultBoard[i][j]);
                    if(j != game.resultBoard[i].length -1)
                        System.out.print(" ");
                }
                System.out.println("");
            }
        } else {
            System.out.println("실패");
        }
    }

    public boolean hasWord(int x, int y, String word) {
        if(!inRange(x, y)) return false;
        else if(!word.substring(0,1).equals(board[x][y])) return false;
        else if(word.length() == 1) {
            resultBoard[x][y] = board[x][y];
            return true;
        }

        for(int direction = 0 ; direction < 8 ; direction++) {
            resultBoard[x][y] = board[x][y];
            int nextX = x + dx[direction], nextY = y + dy[direction];
            if(hasWord(nextX,nextY, word.substring(1))) {
                return true;
            }
        }
        return false;
    }

    public boolean inRange(int x, int y) {
        if(x >= board.length || y >= board[0].length || x < 0 || y < 0) return false;
        return true;
    }

}
