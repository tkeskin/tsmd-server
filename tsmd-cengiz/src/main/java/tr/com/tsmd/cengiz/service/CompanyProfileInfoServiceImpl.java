package tr.com.tsmd.cengiz.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.entity.CompanyProfileEntity;
import tr.com.tsmd.cengiz.models.CompanyProfile;
import tr.com.tsmd.cengiz.repository.CompanyProfileRepository;

@Service
public class CompanyProfileInfoServiceImpl implements CompanyProfileInfoService {
  @Autowired
  CompanyProfileRepository CompanyProfileRepository;


  @Override
  public CompanyProfile getCompanyProfileBy() {
    CompanyProfileEntity entity = CompanyProfileRepository.getBy();
    CompanyProfile CompanyProfile = new CompanyProfile(entity.getId(), entity.getPicture(), entity.getCompanyPresident(),entity.getCompanyProfileExplain(), "data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return CompanyProfile;
  }

  @Override
  public void updateCompanyProfileContent(CompanyProfile companyProfile) {

    CompanyProfileEntity entity = CompanyProfileRepository.getBy();
    entity.setCompanyProfileExplain(companyProfile.getCompanyProfileExplain());
    entity.setCompanyPresident(companyProfile.getCompanyPresident());

    CompanyProfileRepository.save(entity);

  }

  @Override
  public void updateCompanyProfilePicture(Long id, MultipartFile picture) {
    CompanyProfileEntity entity = CompanyProfileRepository.getBy();

    try {
      entity.setFileName(picture.getOriginalFilename());
      entity.setFileType(picture.getContentType());
      entity.setPicture(picture.getBytes());

      CompanyProfileRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
