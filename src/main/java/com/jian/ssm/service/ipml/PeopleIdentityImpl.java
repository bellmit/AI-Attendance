package com.jian.ssm.service.ipml;

import java.util.Base64;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jian.ssm.dao.PeopleIdentityDao;
import com.jian.ssm.entity.PeopleIdentity;
import com.jian.ssm.entity.UserRole;
import com.jian.ssm.service.PeopleIdentityService;

@Service
public class PeopleIdentityImpl  implements  PeopleIdentityService {
	@Resource
	PeopleIdentityDao  pid ;

	@Override
	public int insertPeopleIdentity(PeopleIdentity pi) {
		
		return pid.insertPeopleIdentity(pi);
	}

	@Override
	public List<PeopleIdentity> selectPeopleIdentityByBelongId(int befor, int after, UserRole ur) {
		Base64.Encoder  en  =Base64.getEncoder();
		List<PeopleIdentity>  lp  = pid.selectPeopleIdentityByBelongId(befor, after, ur.getBelongid());
		for(PeopleIdentity  p : lp){
			p.setIdphoto_s("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64,"
					+ en.encodeToString(p.getIdphoto())+ "\"");
			p.setIdphoto(null);
			p.setCameraphoto_s("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64,"
							+ en.encodeToString(p.getCameraphoto()) + "\"");
			p.setCameraphoto(null);
			if(!ur.getUsername().equals("admin")){
				String idcard = p.getIdcard();
				p.setIdcard(idcard.replace(idcard.substring(idcard.length()-8, idcard.length()),"**********" ));
				String adr  = p.getAddress();
				p.setAddress(adr.replace(adr.substring(adr.length()-8, adr.length()), "********"));
			}
			if(p.getCompareResult().equals("成功")){
				p.setCompareResult("<p  class=\"layui-btn  layui-btn-sm layui-btn-normal\">"+p.getCompareResult()+"</p>");
			}else{
				p.setCompareResult("<p  class=\"layui-btn layui-btn-sm layui-btn-danger\">"+p.getCompareResult()+"</p>");
			}
		}
		return  lp ;
	}

	@Override
	public int deletePeopleIdentityByUUID(String uuid) {
		
		return pid.deletePeopleIdentityByUUID(uuid);
	}

	@Override
	public List<PeopleIdentity> selectPeopleIdentityByName(int befor, int after, UserRole ur, String name) {
		Base64.Encoder  en  =Base64.getEncoder();
		List<PeopleIdentity>  lp  = pid.selectPeopleIdentityByName(befor, after, ur.getBelongid(), name);
		for(PeopleIdentity  p : lp){
			p.setIdphoto_s("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64,"
					+ en.encodeToString(p.getIdphoto())+ "\"");
			p.setIdphoto(null);
			p.setCameraphoto_s("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64,"
							+ en.encodeToString(p.getCameraphoto()) + "\"");
			p.setCameraphoto(null);
			if(!ur.getUsername().equals("admin")){
				String idcard = p.getIdcard();
				p.setIdcard(idcard.replace(idcard.substring(idcard.length()-10, idcard.length()),"**********" ));
				String adr  = p.getAddress();
				p.setAddress(adr.replace(adr.substring(adr.length()-8, adr.length()), "********"));
			}
		}
		
		return lp;
	}

	@Override
	public List<PeopleIdentity> selectPeopleIdentityByIdcard(int befor, int after, UserRole ur, String idcard) {
		Base64.Encoder  en  =Base64.getEncoder();
		List<PeopleIdentity>  lp  = pid.selectPeopleIdentityByIdcard(befor, after, ur.getBelongid(), idcard);
		for(PeopleIdentity  p : lp){
			p.setIdphoto_s("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64,"
					+ en.encodeToString(p.getIdphoto())+ "\"");
			p.setIdphoto(null);
			p.setCameraphoto_s("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64,"
							+ en.encodeToString(p.getCameraphoto()) + "\"");
			p.setCameraphoto(null);
			if(!ur.getUsername().equals("admin")){
				String idcard1 = p.getIdcard();
				p.setIdcard(idcard1.replace(idcard1.substring(idcard1.length()-10, idcard1.length()),"**********" ));
				String adr  = p.getAddress();
				p.setAddress(adr.replace(adr.substring(adr.length()-8, adr.length()), "********"));
			}
		}
		return lp;
	}

}
