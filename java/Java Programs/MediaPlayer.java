import java.util.*;

class MediaPlayer {
    static int numOfPlayers = 0;

    String playerName;
    int volumeLevel;
    String currentSong;
    String songSinger;
    String currentVideo;
    String videoCreator;
    String videoAuthor;

    // Constructor using 'this' keyword 
    MediaPlayer(String playerName) {
        this(playerName, 60);
    }

    MediaPlayer(String playerName, int volumeLevel) {
        this.playerName = playerName;
        this.volumeLevel = volumeLevel;
        numOfPlayers++;
    }

    //Static method to display the Total Number of Players currently using the media player
    static void displayTotalPlayers() {
        System.out.println("------------------------------------------");
        System.out.println("Total Media Players: " + numOfPlayers);
        System.out.println("------------------------------------------");
    }

    // Method to display the details of the song/video playing on the Media player
    void play() {
        System.out.println("------------------------------------------");
        System.out.println(playerName + " is playing at volume " + volumeLevel);
        if (currentSong != null) {
            System.out.println("Playing song: " + currentSong);
            System.out.println("Singer: " + songSinger);
        }
        if (currentVideo != null) {
            System.out.println("Playing video: " + currentVideo);
            System.out.println("Creator: " + videoCreator);
            if (videoAuthor != null) {
                System.out.println("Author: " + videoAuthor);
            }
        }
    }
    
    // Method overloding passing arguments in this method
    void play(int volume) {
        this.volumeLevel = volume;
        play();
    }

    //Sets the details of the song when called
    void setSong(String song, String singer) {
        this.currentSong = song;
        this.songSinger = singer;
    }

    // Method overloading with different number of arguments
    void setVideo(String video, String creator) {
        this.currentVideo = video;
        this.videoCreator = creator;
    }

    // Method overloading with different number of arguments
    void setVideo(String video, String creator, String author) {
        this.currentVideo = video;
        this.videoCreator = creator;
        this.videoAuthor = author;
    }
    
    // Method to pause the currently playing song/video
    void pause() {
        System.out.println(playerName + " playback paused.");
    }
    
    // Method to play the currently paused song/video
    void resume() {
        System.out.println(playerName + " playback resumed.");
    }

    // Method to increase volume
    void increaseVolume() {
        if (volumeLevel < 100) {
            volumeLevel += 10;
            System.out.println(playerName + " volume increased to " + volumeLevel);
        } else {
            System.out.println(playerName + " volume is already at maximum level.");
        }
    }

    // Method to decrease volume
    void decreaseVolume() {
        if (volumeLevel > 0) {
            volumeLevel -= 10;
            System.out.println(playerName + " volume decreased to " + volumeLevel);
        } else {
            System.out.println(playerName + " volume is already at minimum level.");
        }
    }

    public static void main(String[] args) {
        // Creating an array of objects
        MediaPlayer[] players = new MediaPlayer[5];
        Scanner s = new Scanner(System.in);
    
        // Media players already playing media
        players[0] = new MediaPlayer("Player 1");
        players[1] = new MediaPlayer("Player 2", 70);
        players[2] = new MediaPlayer("Player 3", 90);
    
        // Taking details of media to be played from the user
        for (int i = 3; i < players.length; i++) {
            System.out.println("Enter song name to be played for player " + (i + 1) + ": ");
            String songName = s.nextLine();
            System.out.println("Enter singer for player " + (i + 1) + ": ");
            String singer = s.nextLine();
            System.out.println("Enter volume level on which the song has to be played for player " + (i + 1) + ": ");
            int volumeLevel = s.nextInt();
            s.nextLine();
            players[i] = new MediaPlayer("Player " + (i + 1), volumeLevel);
            players[i].setSong(songName, singer);
        }
        System.out.println("------------------------------------------");
        System.out.println("-----Details of Current Media Players-----");
    
        // Using object methods
        players[0].setSong("Pehle bhi main", "Vishal Mishra");
        players[0].play();

        // Demonstrating method overloading in the setVideo method
        players[1].setVideo("Method Overloading in Java", "Code with Harry","Haris Ali Khan");
        players[1].play(80);
        players[2].setVideo("Constructors in Java", "Neso Academy");
        players[2].play();
    
    
        // Displaying details of all players
        for (int i = 3; i < players.length; i++) {
            players[i].play();
        }
    
        // Calling the static function to display total players using the media player constructor
        MediaPlayer.displayTotalPlayers();
        
        // Interacting with specific players using a menu
        int playerIndex;
        do {
            System.out.println("------------------------------------------");
            System.out.println("Select a player to interact with (1-5) or enter 0 to exit:");
            playerIndex = s.nextInt();
            s.nextLine(); 
            
            if (playerIndex >= 1 && playerIndex <= 5) {
                playerIndex--; 
                int option;
                do {
                    System.out.println("------------------------------------------");
                    System.out.println("Menu for " + players[playerIndex].playerName + ":");
                    System.out.println("1. Pause the Song/Video");
                    System.out.println("2. Play the Song/Video");
                    System.out.println("3. Increase volume of the player");
                    System.out.println("4. Decrease volume of the player");
                    System.out.println("5. Remove the entire song and player");
                    System.out.println("0. Exit");
                    System.out.println("Enter your choice:");
                    option = s.nextInt();
                    s.nextLine(); 
                    
                    switch (option) {
                        case 1:
                            players[playerIndex].pause();
                            break;
                        case 2:
                            players[playerIndex].resume();
                            break;
                        case 3:
                            players[playerIndex].increaseVolume();
                            break;
                        case 4:
                            players[playerIndex].decreaseVolume();
                            break;
                        case 5:
                            players[playerIndex] = null;
                            System.out.println("Player " + (playerIndex + 1) + " removed.");
                            numOfPlayers--;
                            break;
                        case 0:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid option. Please enter a valid option.");
                    }
                } while (option != 0);
            } else if (playerIndex != 0) {
                System.out.println("Invalid player index. Please enter a valid player index.");
            }
        } while (playerIndex != 0);
    
        // Closing the scanner
        s.close();
}
}
