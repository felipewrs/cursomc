package com.felipesilva.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

public class URL {

	public static List<Integer> decodeIntList(String s) {
		return Arrays.asList(s.split(",")).stream().map(v -> Integer.parseInt(v)).toList();
	}

	public static String decodeParam(String s) {

		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return "";
		}
	}

}
