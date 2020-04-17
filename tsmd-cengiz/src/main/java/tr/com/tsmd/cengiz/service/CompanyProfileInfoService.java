package tr.com.tsmd.cengiz.service;

import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.models.About;
import tr.com.tsmd.cengiz.models.AboutList;
import tr.com.tsmd.cengiz.models.CompanyProfile;

public interface CompanyProfileInfoService {

  CompanyProfile getCompanyProfileBy();

  void updateCompanyProfileContent(CompanyProfile companyProfile);

  void updateCompanyProfilePicture(Long id, MultipartFile picture);
}
