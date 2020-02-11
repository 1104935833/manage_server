package hxc.manage.model;

import lombok.Data;

@Data
public class Performance {

   private int id;

   private String performance_name;

   private String performance_class;

   private String time;

   private String first_author;

   private String complete_author;

   private String grade;

   private Double performance_point;

   private String audit_condition;

   private String material_condition;

   private String note;

   private int user_id;

}
