package main;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.aql.access.JvdUmagotoRaceJohoSession;
import com.pckeiba.entity.JvdUmagotoRaceJoho;

public class ListTest {

	public static void main(String[] args) {
		new ListTest();
	}

	public ListTest() {
		try (JvdUmagotoRaceJohoSession rs = new JvdUmagotoRaceJohoSession();) {
			rs.getExample().createCriteria().andRaceCodeEqualTo("2019042808030310");
			list = rs.getMapper().selectByExample(rs.getExample());
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		System.out.println("aout");

		setRaceCodeList(list.stream()
						   .map(s -> s.getKettoTorokuBango())
						   .collect(Collectors.toList()));
	}

	public List<JvdUmagotoRaceJoho> getList() {
		return list;
	}

	public List<String> getRaceCodeList() {
		return raceCodeList;
	}

	private void setRaceCodeList(List<String> raceCodeList) {
		this.raceCodeList = raceCodeList;
	}

	private List<JvdUmagotoRaceJoho> list;

	private List<String> raceCodeList;

}
