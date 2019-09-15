package org.codenergic.simcat.user;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codenergic.theskeleton.core.data.AbstractAuditingEntity;
import org.codenergic.theskeleton.user.UserEntity;

@Entity
@Table(name = "cat_contact")
class ContactEntity extends AbstractAuditingEntity {
	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	@ManyToOne
	@JoinColumn(name = "contact_id")
	private UserEntity contact;
	@NotNull
	private String name;
	private String phoneNumber;
	private String email;

	public UserEntity getContact() {
		return contact;
	}

	public ContactEntity setContact(UserEntity contact) {
		this.contact = contact;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public ContactEntity setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getName() {
		return name;
	}

	public ContactEntity setName(String contract) {
		this.name = contract;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public ContactEntity setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public UserEntity getUser() {
		return user;
	}

	public ContactEntity setUser(UserEntity user) {
		this.user = user;
		return this;
	}
}
