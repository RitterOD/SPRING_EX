package org.maslov.checkerframework11jdk;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Checkerframework11jdkApplication {

	private static int countArgs(@NonNull String[] args) {
		return args.length;
	}

	public static void main(@Nullable String[] args) {
		countArgs(args);
		SpringApplication.run(Checkerframework11jdkApplication.class, args);
	}

}
