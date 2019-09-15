package org.codenergic.simcat.chat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.codenergic.theskeleton.core.data.AbstractAuditingEntity;
import org.codenergic.theskeleton.user.UserEntity;

@Entity
@Table(name = "cat_member", uniqueConstraints = {@UniqueConstraint(columnNames = {"room_id", "member_id"})})
class MemberEntity extends AbstractAuditingEntity {
	@NotNull
	@ManyToOne
	@JoinColumn(name = "room_id")
	private RoomEntity room;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "member_id")
	private UserEntity roomMember;
	@NotNull
	private boolean admin = false;
	@NotNull
	private boolean moderator = false;

	public RoomEntity getRoom() {
		return room;
	}

	public MemberEntity setRoom(RoomEntity room) {
		this.room = room;
		return this;
	}

	public UserEntity getRoomMember() {
		return roomMember;
	}

	public MemberEntity setRoomMember(UserEntity member) {
		this.roomMember = member;
		return this;
	}

	public boolean isAdmin() {
		return admin;
	}

	public MemberEntity setAdmin(boolean admin) {
		this.admin = admin;
		return this;
	}

	public boolean isModerator() {
		return moderator;
	}

	public MemberEntity setModerator(boolean moderator) {
		this.moderator = moderator;
		return this;
	}
}
