package com.jjplanet.ssaibrary.api.member.model;

import lombok.Getter;

@Getter
public enum JwtCode {

	DENIED,
	ACCESS,
	EXPIRED;
}