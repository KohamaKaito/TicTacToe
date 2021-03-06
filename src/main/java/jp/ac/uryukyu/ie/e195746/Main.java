package jp.ac.uryukyu.ie.e195746;


public class Main {
    public static void main(String[] args) {
        Board board = new Board("⬜");
        User user = new User("⭕", board);
        Bot bot = new Bot("❌", board);
        GameMaster gameMaster = new GameMaster(board);
        board.showboard();

        while (true) {
            while (true) {
                try {
                    int number = user.getNumber();
                    int alphabet = user.getAlphabet();
                    if (gameMaster.isSpace(number, alphabet)) {
                        user.play(number, alphabet);
                        break;
                    } else {
                        System.out.println("そこには置けません。");
                        board.showboard();
                    }
                }catch (NumberFormatException e) {
                    System.out.println("例外が発生しました");
                    System.out.println("正しい文字を入力してください");
                    board.showboard();
                    continue;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("例外が発生しました");
                    System.out.println("正しい文字を入力してください");
                    board.showboard();
                    continue; }
            }
            if (gameMaster.isjudge(user.unit)) {
                System.out.println("(" + user.unit + "):YOU WIN!!");
                break;
            }
            if (gameMaster.isDraw()) {
                System.out.println("DRAW..");
                break;
            }


            while (true) {
                int number = bot.getNumber();
                int alphabet = bot.getAlphabet();
                if (gameMaster.isSpace(number, alphabet)) {
                    bot.play(number, alphabet);
                    break;
                }
            }
            if (gameMaster.isjudge(bot.unit)) {
                System.out.println("YOU LOSE..");
                break;
            }
            if (gameMaster.isDraw()) {
                System.out.println("DRAW..");
                break;
            }
        }
    }
}
