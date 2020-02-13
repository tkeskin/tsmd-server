package tr.com.tsmd.auth.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.tsmd.auth.entity.UserInfoEntity;
import tr.com.tsmd.auth.models.User;
import tr.com.tsmd.auth.models.UserList;
import tr.com.tsmd.auth.repository.UserInfoRepository;

@Transactional
@Service
public class UserInfoServiceImpl implements UserInfoService {

  @Autowired
  UserInfoRepository userInfoRepository;

  @Override
  public UserList getUserInfo() {
    List<UserInfoEntity> all = userInfoRepository.findAll();

    /*List<User> user = Arrays.asList(
        new User("Bintuğ Taha", "KESKİN","2527"),
        new User("İlker", "ÇİFTÇİ","2528")
    );*/

    List<User> users = all
        .stream()
        .map(x -> new User(x.getUserEntity().getName(), x.getUserEntity().getSurname(),
            x.getExtensionNumber()))
        .collect(Collectors.toList());

    UserList userList = new UserList();
    userList.setUserList(users);

    return userList;
  }
}
