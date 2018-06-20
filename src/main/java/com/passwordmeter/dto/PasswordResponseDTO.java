package com.passwordmeter.dto;

import java.io.Serializable;
import java.util.Objects;

public class PasswordResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer score;
	
	private String complexity;
	
	public Integer getScore() {
		return score;
	}

	public String getComplexity() {
		return complexity;
	}

	public static class PasswordResponseBuilder {

        private PasswordResponseDTO dto;

        public PasswordResponseBuilder() {
            dto = new PasswordResponseDTO();
        }

        public PasswordResponseBuilder withScore(Integer score) {
            dto.score = score;
            return this;
        }

        public PasswordResponseBuilder withComplexity(String complexity) {
            dto.complexity = complexity;
            return this;
        }

        public PasswordResponseDTO build() {
            return dto;
        }
    }

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof PasswordResponseDTO)) {
			return false;
		}
		PasswordResponseDTO castOther = (PasswordResponseDTO) other;
		return Objects.equals(score, castOther.score) && Objects.equals(complexity, castOther.complexity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(score, complexity);
	}
}
