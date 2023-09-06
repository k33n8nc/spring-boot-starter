package nl.keenagency.videodb;

import nl.keenagency.videodb.controller.VideoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class VideodbApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void init(){
		this.mockMvc = MockMvcBuilders
				.standaloneSetup(VideoController.class)
				.build();
	}

	@Test
	public void contextLoads() {
	}

}
