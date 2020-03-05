package com.telego.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ModelDTO {
	private boolean markedAsDeleted;

	public static List<? extends ModelDTO> filterUpdatesModels(List<? extends ModelDTO> models) {
		if (models == null)
			return null;
		return models.stream().filter(model -> model.isMarkedAsDeleted()).collect(Collectors.toList());
	}

	public static List<? extends ModelDTO> filterDeletesModels(List<? extends ModelDTO> models) {
		if (models == null)
			return null;
		return models.stream().filter(model -> model.isMarkedAsDeleted()).collect(Collectors.toList());
	}
}
