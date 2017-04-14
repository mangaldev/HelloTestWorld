package entities;

import java.io.Serializable;
import java.util.List;

public class AutomapJob implements Serializable{
	public String remote_id;
	public String series_title;
	public String title;
	public String air_date;
	public String episode_number;
	public String season_number;
	public List<String> credit_list;
	public String language;
	public String run_time;
	public String content_type;
	public Integer programMappingSchemeId;

	public String getContent_type() {return content_type;}
	public String getSeries_title() {
		return series_title;
	}
	public String getTitle() {
		return title;
	}
	public String getAir_date() {
		return air_date;
	}
	public String getEpisode_number() {
		return episode_number;
	}
	public String getSeason_number() {
		return season_number;
	}
	public List<String> getCredit_list() {
		return credit_list;
	}
	public String getLanguage() {
		return language;
	}
	public String getRun_time() {
		return run_time;
	}

	@Override
	public String toString() {
		return "AutomapJob{" +
				"remote_id='" + remote_id + '\'' +
				", series_title='" + series_title + '\'' +
				", title='" + title + '\'' +
				", air_date='" + air_date + '\'' +
				", episode_number='" + episode_number + '\'' +
				", season_number='" + season_number + '\'' +
				", credit_list=" + credit_list +
				", language='" + language + '\'' +
				", run_time='" + run_time + '\'' +
				", content_type='" + content_type + '\'' +
				", programMappingSchemeId=" + programMappingSchemeId +
				'}';
	}
}
