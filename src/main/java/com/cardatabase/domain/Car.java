package com.cardatabase.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String brand, model, color, registerNumber;
	@Column(name="years")
	private int year; 
	private int price;
	
	//일대다 관계를 추가하려면 @ManyToOne 및 @OneToMay 어노테이션을 이용한다
	//Car 엔티티 클래스에서는 @ManyToOne 어노테이션으로 관계를 정의해야 한다
	//FetchType.LAZY은 데이터베이스에서 데이터를 검색하는 전략을 정의한다
	//지정 가능한 값은 즉시 검색을 의미하는 EAGER
	//지연 검색을 의미하는 LAZY
	//지연 검색은 데이터베이스에서 소유자를 검색하면 필요할 때에 해당 소유자와
	//연관된 모든 자동차를 검색한다는 뜻이다.
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="owner")
	private Owner owner;
	
	public Car(String brand, String model, String color, 
			String registerNumber, int year, int price
			,Owner owner) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.year = year;
		this.price = price;
		this.owner=owner;
	}
}
