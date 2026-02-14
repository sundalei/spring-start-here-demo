package com.example.model;

import java.math.BigDecimal;

public record Account(long id, String name, BigDecimal amount) {}
