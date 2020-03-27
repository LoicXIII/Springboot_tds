package com.example.tp5;

import com.example.tp5.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp5Application {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private HistoryRepository historyRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private ScriptRepository scriptRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {

		SpringApplication.run(Tp5Application.class, args);
	}

}
