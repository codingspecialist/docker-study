package com.cos.authjwt.domain.post;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cos.authjwt.domain.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "post_tb")
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // auto_increment
	@Column(nullable = false, length = 100)
	private String title;
	@Column(nullable = false, length = 10000)
	private String content;

	@JoinColumn(nullable = false, name = "userId")
	@ManyToOne
	private User user;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	@CreationTimestamp
	private LocalDateTime created;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	@UpdateTimestamp
	private LocalDateTime updated;

}
