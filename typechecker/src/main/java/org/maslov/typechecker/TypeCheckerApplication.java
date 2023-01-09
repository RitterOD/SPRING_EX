package org.maslov.typechecker;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TypeCheckerApplication {

	private static int countArgs(@NonNull @org.springframework.lang.NonNull String[] args) {
		return args.length;
	}

	public static void main(@Nullable String[] args)
	{
		countArgs(args);
		SpringApplication.run(TypeCheckerApplication.class, args);
	}

}
