package com.example.dto;

import java.math.BigDecimal;

public record TransferRequest(long senderAccountId, long receiverAccountId, BigDecimal amount) {}
