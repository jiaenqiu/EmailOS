package com.web.emailOS.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import com.web.emailOS.bean.ResponseBean;
import com.web.emailOS.bean.User;
import com.web.emailOS.service.IUserService;
import com.web.emailOS.util.ReadFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Iterator;

@Controller
@RequestMapping("/user") 
public class UserController {
	/**
     * 使用@Autowired也可以，@Autowired默认按类型装配
     * @Resource 默认按名称装配，当找不到与名称匹配的bean才会按类型装配。
     */
	@Resource
	private IUserService userService;

	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public int addUser(@RequestParam String user_name,@RequestParam String user_phone,@RequestParam String user_id_card,@RequestParam String user_content) {
		User user = new User();
		user.setUser_name(user_name);
		user.setUser_phone(user_phone);
		user.setUser_id_card(user_id_card);
		user.setUser_content(user_content);
		return userService.addUser(user);
	}

	@RequestMapping(value="/queryAllUsers", method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean queryAllUsers() {
		ResponseBean rb = new ResponseBean();
		JSONArray users = userService.queryAllUsers();
		System.out.println("****queryAllUsers************"+users);
		rb.setMsg("查询所有用户");
		rb.setResult(users.toString());
		rb.setFlag(true);
		return rb;
	}

	@RequestMapping(value="/selectUserById", method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean selectUserById(@RequestParam int user_id) {
		ResponseBean rb = new ResponseBean();
		User user = userService.selectUserById(user_id);
		JSONObject u = new JSONObject();
		u.put("user_name",user.getUser_name());
		u.put("user_phone",user.getUser_phone());
		u.put("user_id_card",user.getUser_id_card());
		u.put("user_content",user.getUser_content());
		System.out.println("****selectUserById************"+u);
		rb.setMsg("查询ID为："+user_id+"的用户");
		rb.setResult(u.toString());
		rb.setFlag(true);
		return rb;
	}

	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	@ResponseBody
	public int editUserById(@RequestParam int user_id,@RequestParam String user_name,@RequestParam String user_phone,@RequestParam String user_id_card,@RequestParam String user_content) {
		System.out.println("**********editUserById**************参数："+user_id);
		User user = new User();
		user.setUser_id(user_id);
		user.setUser_name(user_name);
		user.setUser_phone(user_phone);
		user.setUser_id_card(user_id_card);
		user.setUser_content(user_content);
		return userService.updateUser(user);
	}

	@RequestMapping(value="/delUserById", method=RequestMethod.POST)
	@ResponseBody
	public int delUserById(@RequestParam int user_id) {
		System.out.println("**********delUserById**************参数："+user_id);
		return userService.delUserById(user_id);
	}

	/**
	 * 采用spring提供的上传文件的方法
	 */
	@RequestMapping(value="/upLoadFile", method=RequestMethod.POST)
	public String  upLoadFile(HttpServletRequest request) throws IllegalStateException, IOException {
		long  startTime=System.currentTimeMillis();
		//将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
		//检查form中是否有enctype="multipart/form-data"
		if(multipartResolver.isMultipart(request)) {
			//将request变成多部分request
			MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
			//获取multiRequest 中所有的文件名
			Iterator iter=multiRequest.getFileNames();
			while(iter.hasNext()) {
				//一次遍历所有文件
				MultipartFile file=multiRequest.getFile(iter.next().toString());
				if(file!=null) {
					//String path="/Users/jiaenqiu/Downloads/workspace-web/emailOS/uploadfiles/"+file.getOriginalFilename();
					String path = ReadFile.readFile("uploadPath")+file.getOriginalFilename();
					//System.out.println("path："+path);
					File f = new File(path);
					if(f.exists()) {
						f.delete();
						System.out.println("文件已存在，删除后再上传");
					}
					file.transferTo(f);//上传
				}
			}
		}
		long  endTime=System.currentTimeMillis();
		System.out.println("上传文件运行时间："+String.valueOf(endTime-startTime)+"ms");
		return "redirect:/index.html";
	}
}
