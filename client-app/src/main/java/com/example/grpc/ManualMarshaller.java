package com.example.grpc;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.grpc.MethodDescriptor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ManualMarshaller<T> implements MethodDescriptor.Marshaller<T> {

	private static final ObjectMapper mapper = new ObjectMapper();
	private final Class<T> clazz;

	public ManualMarshaller(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public InputStream stream(T value) {
		try {
			return new ByteArrayInputStream(mapper.writeValueAsBytes(value));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public T parse(InputStream stream) {
		try {
			return mapper.readValue(stream, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
