package org.codenergic.simcat.chat;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.codenergic.theskeleton.core.data.AbstractAuditingEntity;
import org.codenergic.theskeleton.user.UserEntity;

@Entity
@Table(name = "cat_room", uniqueConstraints = {@UniqueConstraint(columnNames = {"creator_id", "title"})})
class RoomEntity extends AbstractAuditingEntity {
	@NotNull
	@ManyToOne
	@JoinColumn(name = "creator_id")
	private UserEntity creator;
	@NotNull
	private String title;
	@NotNull
	private boolean group = false;
	@Lob
	private String pictureUrl;
	@OneToMany(mappedBy = "room", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	private Set<MemberEntity> members;

	public UserEntity getCreator() {
		return creator;
	}

	public RoomEntity setCreator(UserEntity creator) {
		this.creator = creator;
		return this;
	}

	public Set<MemberEntity> getMembers() {
		return members;
	}

	public RoomEntity setMembers(Set<MemberEntity> members) {
		this.members = members;
		return this;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public RoomEntity setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public RoomEntity setTitle(String title) {
		this.title = title;
		return this;
	}

	public boolean isGroup() {
		return group;
	}

	public RoomEntity setGroup(boolean group) {
		this.group = group;
		return this;
	}
}
