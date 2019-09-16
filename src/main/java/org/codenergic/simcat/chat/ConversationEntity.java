package org.codenergic.simcat.chat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.codenergic.theskeleton.core.data.AbstractAuditingEntity;

@Entity
@Table(name = "cat_conversation", uniqueConstraints = {@UniqueConstraint(columnNames = {"owner_id", "room_id"})})
class ConversationEntity extends AbstractAuditingEntity {
	@NotNull
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private MemberEntity owner;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "room_id")
	private RoomEntity room;

	public MemberEntity getOwner() {
		return owner;
	}

	public void setOwner(MemberEntity owner) {
		this.owner = owner;
	}

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}
}
