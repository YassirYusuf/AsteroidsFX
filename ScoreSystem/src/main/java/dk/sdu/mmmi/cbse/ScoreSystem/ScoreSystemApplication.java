package dk.sdu.mmmi.cbse.ScoreSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScoreSystemApplication {

	private Long totalScore = 0L;

	public static void main(String[] args) {
		SpringApplication.run(ScoreSystemApplication.class, args);
	}

	@GetMapping("/score/add")
	public Long addScore(@RequestParam(value = "point") Long point) {
		totalScore += point;
		return totalScore;
	}

	@GetMapping("/score")
	public Long getScore() {
		return totalScore;
	}
}
