package de.rallye.model.mapper;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import de.rallye.model.structures.Node;


public class EdgeNodeSerializer extends JsonSerializer<Node> {

	@Override
	public void serialize(Node value, JsonGenerator jsonGenerator, SerializerProvider arg2)
			throws IOException {
		jsonGenerator.writeNumber(value.nodeID);
	}

}
