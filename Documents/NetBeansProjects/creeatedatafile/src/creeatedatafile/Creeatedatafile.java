/*
 */

package creeatedatafile;

// Imports the io library to allow file management.
import java.io.*;

// Imports the utility library to allow use of arrays.
import java.util.*;
/**
 * By: Safayat Jamal
 * 10/03/16
 * Purpose: To allow teachers to record results of student quizzes (of four questions).
 */
public class Creeatedatafile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Try statement starts.
        try {
            
            // Creates the datafile for the student scores. Note that if there is an existing file it will be replaced.
            File dataFile = new File("Stuscores.dat");
            
            // Sends out a file stream.
            FileWriter out;
            
            // Initializing the buffered writer as writeFile.
            BufferedWriter writeFile;
            
            // Scanner used to extract text from the output line.
            Scanner input = new Scanner(System.in);
            
            // Initializes the array of right answers.
            String[] rightAnswers ={"","","",""};
                
                // "out" is a FileWrtier stream based on the dataFile of Stuscores.
                out = new FileWriter(dataFile);
                
                // writeFile is a BufferedWriter based on the "out" output stream.
                writeFile = new BufferedWriter(out);
                
                // Used to write the statement of correct answers in the file.
                writeFile.write("Correct Answers:");
                
                // New line in the file.
                writeFile.newLine();
            
            // For loop for the correct answers. Note that there can only be four answers so there are four questions only.    
            for(int i=0;i<4;i++){
                
                // The count starts at 1 not 0 unlike the index.
                int count = i+1;
                
                // Prompt to enter the correct answer.
                System.out.println("Enter correct answer #" + count + ": (No spaces) " );
                
                // User input is now one of the right answers. This allows for flexibility on the answer given.
                rightAnswers[i] = input.next();
                
                // Also writes the answrs into the file.
                writeFile.write(rightAnswers[i]);
                
                // New line in the file.
                writeFile.newLine();
                
            }
            
            // New line in the file.
            writeFile.newLine();
            
            // The string array of student names are declared as blank.
            String[] students ={"","","",""};
            
            // The score of each student.
            int[] score;
            
            // This array is given four slots due to only four questions being the quiz.
            score = new int[4]; 
            
            // String used for the student name. It is declared before being used.
            String name;
                      
            // For loop to go through each student. Note the variable "i" will represent the index of that student.
            for (int i= 0; i < 4;i++) {
                
                // Prompts the user to enter the student's name.
                System.out.println("Enter student name: (No spaces) ");
                
                // The name is the next user input.
                name = input.next();
                
                // The student name string of the "i" index is now that name.
                students[i] = name;
                
                // This name is also written in the file.
                writeFile.write(name);
                
                // New line is added in the file.
                writeFile.newLine();
               
                // For loop to go through each question. Note the variable "j" will represent the index of that question.
                for (int j=0;j<4;j++){
                    
                    // The count will obviously start at one as the index will not.
                    int count = j +1;   
                    
                    // Prompts the user to enter the student's answer to this question.
                    System.out.print("Enter the student's answer to question "+ count +" : ");
                    
                    // The answer is taken as the string "letter".
                    String letter = input.next();
              
                    // If statement to check if the student's answer of that specific question (declared as j) is the same.
                    if(letter.equals(rightAnswers[j])){
                        
                        // The score of the student increases by 25 because they answered correctly.
                        score[i] = score[i] +25;
                        
                    }
                    
                    // The student answer is also written to the file with a space in between other answers.
                    writeFile.write(letter + " ");
              
                }
                
                // New line is added to the file.
                writeFile.newLine();
                
            }
            
            // New line is added to the file.
            writeFile.newLine();
            
            // For loop for the scores of the students being dealt with.
            for(int k =0;k<4;k++){
            
                // The student string will follow the "k" student.
                String student = students[k];
                
                // Shows the user the student name with their score with a percentage.
                System.out.println(student +": "+ score[k] + "%");
                
                // Same line, just writes it to the file.
                writeFile.write(student +": "+ score[k] + "%");
                
                // New line is added to the file.
                writeFile.newLine();
            }
            
            // Closes the writeFile stream.
            writeFile.close();
            
            // Closes the "out" fileWriter.
            out.close();
            
            // Tells the user that the data was successfully written to the file.
            System.out.println("Data written to file.");
        
        // Catch statement catches the IOException error if something is wrong.    
        }catch (IOException e) {
            
            // Tells the user that there is a problem writing.
            System.out.println("Problem writing to file.");
            
            // Shows the user the IOException error.
            System.err.println("IOException:" + e.getMessage());
            
        }
        
    }
        
}
    

