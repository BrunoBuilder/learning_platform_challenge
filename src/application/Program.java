package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("how many classes does the course have? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println((i+1) + "st class data:");
			System.out.print("Content or task (c/t)? ");
			char ch = sc.next().toLowerCase().charAt(0);
			while(ch != 'c' && ch != 't') {
				System.out.print("Input error! Content or task (c/t)? ");
				ch = sc.next().toLowerCase().charAt(0);
			}
			System.out.print("Title: ");
			sc.nextLine();
			String title = sc.nextLine();
			if(ch == 'c') {
				System.out.print("Video URL: ");
				String url = sc.next();
				System.out.print("Duration in seconds: ");
				int duration = sc.nextInt();
				list.add(new Video(title, url, duration));
			} else {
				System.out.print("Description: ");
				String description = sc.nextLine();
				System.out.print("Number of questions: ");
				int numberOfQuestions = sc.nextInt();
				list.add(new Task(title, description, numberOfQuestions));
			}
			
		}
		
		System.out.println();
		totalCourseDuration(list);
		
		sc.close();
	}
	
	public static void totalCourseDuration(List<Lesson> lessons) {
		int totalDuration = 0;
		for (Lesson lesson : lessons) {
			totalDuration += lesson.duration();
		}
		System.out.println("TOTAL COURSE DURATION: " + totalDuration + " SECONDS");
	}

}
