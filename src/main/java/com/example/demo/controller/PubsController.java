package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Pubs;
import com.example.demo.payload.PubsResponse;
import com.example.demo.payload.UserReponse;
import com.example.demo.service.PubsService;



@RestController
@RequestMapping("/api/pubs")
public class PubsController extends CrudController<Pubs, Long>{
	
	@Autowired
	private PubsService pubsService;

	public void add(@RequestBody Pubs pub) {
		String time;
    	Date date = new Date();
    	SimpleDateFormat s=new SimpleDateFormat("hh:mm - dd-MM-yyyy");
    	time =s.format(date);
    	pub.setCreatedAt(time);
    	super.add(pub);    	
	}

		@GetMapping(value="GetAllPubs")
	public List<PubsResponse> GetAllPubs() {
			List<PubsResponse>ele= new ArrayList<PubsResponse>();
			//Set<CommentsResponse> comm = new HashSet<>();
			//List<Comments> commt= new ArrayList<Comments>();
			for(Pubs pu :super.getAll()) {  
			/*for(Comments p :pu.getComment()) {
				UserReponse userResp = new UserReponse(p.getUser().getId(),p.getUser().getEmail(),p.getUser().getFirstname(),p.getUser().getLastname(),p.getUser().getPhoto());
				CommentsResponse commentRespo =new CommentsResponse(p.getDescription(),p.getCreatedAt(),userResp);
				comm.add(commentRespo);
				
			}*/
		
		UserReponse userRespo = new UserReponse(pu.getUser().getId(),pu.getUser().getEmail(),pu.getUser().getFirstname(),pu.getUser().getLastname(),pu.getUser().getPhoto());
		PubsResponse pubsRepso = new PubsResponse(pu.getId(), pu.getDescription(), pu.getPosition(), pu.getCreatedAt(),pu.isEnable(), pu.getPhoto(), userRespo);
		ele.add(pubsRepso);
			
		}
			return ele;
				
				}
	
		@RequestMapping(value = "/status/{id}", method = RequestMethod.PUT)
			public void update(@PathVariable(value = "id")Long id) {
			pubsService.updateStatus(id);
		}
		
		@RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
		public PubsResponse getPubByid(@PathVariable(value = "id")Long id) {
			Pubs pu=new Pubs();
			pu=pubsService.findone(id);
			UserReponse userRespo = new UserReponse();
			PubsResponse pubsRepso = new PubsResponse(pu.getId(), pu.getDescription(), pu.getPosition(), pu.getCreatedAt(),pu.isEnable(), pu.getPhoto(), userRespo);
			return pubsRepso;
		}
	
}
