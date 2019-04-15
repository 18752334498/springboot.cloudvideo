user表，address表，一对多
第一和第三中，address表中的user_id默认是关联user表中的主键id
======================================================================
User.class：
			id
			name
			@OneToMany
			@JoinColumn("user_id")
			List<Address>
Address.class:
			id
			address
此时，会在address表中生成一个user_id，user表两个列名，address表三个列名

======================================================================
User.class：
			id
			name
			@Column(user_id)
			userId
			@OneToMany(mappedBy = "user")
			List<Address>
Address.class:
			id
			address
			@JoinColumn(name = "user_id", referencedColumnName = "user_id")//第一个user_id是address表中的列名，第二个是关联user_id表中的user_id
    		@ManyToOne
			User user
user表三个列名，address表三个列名

======================================================================
User.class：
			id
			name
			@OneToMany(mappedBy = "userId")
			List<Address>
Address.class:
			id
			address
			userId
user表两个列名，address表三个列名
