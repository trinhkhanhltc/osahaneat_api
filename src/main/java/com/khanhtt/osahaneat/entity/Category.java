package com.khanhtt.osahaneat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.Set;
import lombok.Data;

@Data
@Entity(name = "category")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String nameCate;
  private Date createDate;

  @OneToMany(mappedBy = "category")
  private Set<Food> listFood;
  @OneToMany(mappedBy = "category")
  private Set<MenuRestaurant> listMenuRestaurant;
}
