package com.example.canvaTcc.model.entity;

public enum Category {
    ISSUES(1),
    SOLUTIONS(2),
    RESULTS(3),
    USERS(4),
    RESULTS_USER(5),
    HYPOTHESES(6),
    FIRST_LEARN(7),
    MOST_IMPORTANT(8);

    private final int value;

    private Category(Integer value) {
        this.value = value;
    }

    public static Category fromValue(Integer value) {
        for (Category category : Category.values()) {
            if (value == category.getValue()) {
                return category;
            }
        }
        throw new IllegalArgumentException("Categora iválida:"+ value);
    }

    public int getValue() {
        return value;
    }
}
