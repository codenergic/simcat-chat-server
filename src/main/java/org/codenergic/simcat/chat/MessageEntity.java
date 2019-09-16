package org.codenergic.simcat.chat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codenergic.theskeleton.core.data.AbstractAuditingEntity;
import org.codenergic.theskeleton.user.UserEntity;

@Entity
@Table(name = "cat_message")
class MessageEntity extends AbstractAuditingEntity {
	@NotNull
	@ManyToOne
	@JoinColumn(name = "conversation_id")
	private ConversationEntity conversation;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "from_id")
	private UserEntity from;
	@ManyToOne
	@JoinColumn(name = "reply_to_id")
	private MessageEntity replyTo;
	@Lob
	private String text;
	@Lob
	@Column(name = "attachment_url")
	private String attachmentUrl;
	@Lob
	@Column(name = "attachment_thumb_url")
	private String attachmentThumbUrl;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "message_type")
	private MessageType messageType = MessageType.TEXT;

	public String getAttachmentThumbUrl() {
		return attachmentThumbUrl;
	}

	public MessageEntity setAttachmentThumbUrl(String attachmentThumbUrl) {
		this.attachmentThumbUrl = attachmentThumbUrl;
		return this;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public MessageEntity setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
		return this;
	}

	public ConversationEntity getConversation() {
		return conversation;
	}

	public MessageEntity setConversation(ConversationEntity conversation) {
		this.conversation = conversation;
		return this;
	}

	public UserEntity getFrom() {
		return from;
	}

	public MessageEntity setFrom(UserEntity from) {
		this.from = from;
		return this;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public MessageEntity setMessageType(MessageType messageType) {
		this.messageType = messageType;
		return this;
	}

	public MessageEntity getReplyTo() {
		return replyTo;
	}

	public MessageEntity setReplyTo(MessageEntity replyTo) {
		this.replyTo = replyTo;
		return this;
	}

	public String getText() {
		return text;
	}

	public MessageEntity setText(String text) {
		this.text = text;
		return this;
	}
}
