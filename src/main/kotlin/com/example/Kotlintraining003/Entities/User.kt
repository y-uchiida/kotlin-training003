package com.example.Kotlintraining003.Entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDate

// @Entity アノテーション
// JPA が提供するアノテーションで、データベースとのORMとしての機能をクラスに追加する
// エンティティとなったクラスは、データベースから内容を取り出してインスタンス化したり、
// インスタンスの内容をデータベースへシームレスに保存できるようになる
@Entity
data class User(
	// コンストラクタで受け取るべきプロパティは、引数に設定する
	var name: String = "",
	var email: String = "",
	var password: String = "",
	var registered_at: LocalDate = LocalDate.now(),
) {
	// エンティティにおいて特別な役割を持つプロパティは、クラス定義内でアノテーションをつけて宣言する
	// 例えば id は、データベースのプライマリキーとして扱うものなので、
	// @Id アノテーションと @GeneratedValue アノテーションをつける
	@Id
	@GeneratedValue
	var id: Long = 0
}
