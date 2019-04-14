// Criando uma Classe para Converção para YAML

package com.tiosso.rest.microservices.restfulwebservices.config;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {
	YamlJackson2HttpMessageConverter() {
		super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
	}
}