package hxc.manage.service;

import java.util.List;
import java.util.Map;

public interface CommonService {

    List<Map<String, Object>> findOption(String option, String title, String value, String id);

    String getUserRole(String user_id);
}
