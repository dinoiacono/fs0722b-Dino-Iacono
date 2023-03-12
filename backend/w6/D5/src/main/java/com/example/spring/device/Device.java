package com.example.spring.device;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "devices")
@Data
@NoArgsConstructor
@ToString
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private DeviceStatus status;
	
	@Enumerated(EnumType.STRING)
	private DeviceType Type;
	
	public Device(DeviceStatus s, DeviceType t){
		super();
		this.status = s;
		this.Type = t;
	}

}
