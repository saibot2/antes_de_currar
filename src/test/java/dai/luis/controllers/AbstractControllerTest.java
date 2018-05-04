package dai.luis.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;

public class AbstractControllerTest {
	private MockMvc mockMvc;

	protected void setUp(Object controller) {
		mockMvc = standaloneSetup(controller).setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver()).build();
	}
	
	protected ModelAndView assertExpectedMAVGet(String uri, String viewName) throws Exception {
		MvcResult response = getMvcResultGetRequest(uri);
		return assertViewName(viewName, response);
	}
	
	protected ModelAndView assertExpectedMAVGet(MockHttpSession session, String uri, String viewName) throws Exception {
		MvcResult response = getMvcResultGetRequest(session, uri);
		return assertViewName(viewName, response);
	}
	
	private MvcResult getMvcResultGetRequest(String uri) throws Exception {
		MvcResult response = mockMvc.perform(get(uri)).andExpect(status().isOk()).andReturn();
		return response;
	}

	private MvcResult getMvcResultGetRequest(MockHttpSession session, String uri) throws Exception {
		MvcResult response = mockMvc.perform(get(uri).session(session)).andExpect(status().isOk()).andReturn();
		return response;
	}
	private ModelAndView assertViewName(String viewName, MvcResult response) {
		assertNotNull(response);
		ModelAndView modelAndView = response.getModelAndView();
		assertNotNull(modelAndView);
		assertEquals(viewName, modelAndView.getViewName());
		return modelAndView;
	}
	
	public MockMvc getMockMvc() {
		return mockMvc;
	}

	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}
}
