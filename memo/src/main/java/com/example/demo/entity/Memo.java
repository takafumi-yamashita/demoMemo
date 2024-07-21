package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //データの入れ物であるEntityクラスであることを指定する
@Table(name = "memo") //テーブル名を設定
@Data //全フィールドに対してgetter/setterでアクセスすることができる
public class Memo {

	@Id // Entityの主キーを設定する
	// メモID
	private int id;
	// タイトル
	private String title;
	// コンテンツ
	private String content;
	// 削除フラグ
	private boolean deleted;
	// 作成日
	@CreationTimestamp
	@Column(name = "createdAt", updatable = false)
	private LocalDateTime createdAt;
	// 更新日
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;

	public LocalDate getCreatedDate() {
		return createdAt.toLocalDate();
	}

	public LocalDate getUpdatedDate() {
		return updatedAt.toLocalDate();
	}
}
