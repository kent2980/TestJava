package main;

import java.io.IOException;
import java.util.List;

import com.aql.access.UmaDataViewSession;
import com.example.entity.UmaDataView;

public class Test {

		public static void main(String[] args) {
			List<String> raceCodeList = new ListTest().getRaceCodeList();
			System.out.println("start");
			List<UmaDataView> list = null;
			try (UmaDataViewSession rs = new UmaDataViewSession();) {
				rs.getExample().createCriteria().andKettoTorokuBangoIn(raceCodeList);
				rs.getExample().setOrderByClause("bamei asc");
				list = rs.getMapper().selectByExample(rs.getExample());
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}

			for(UmaDataView data : list) {
				System.out.println(data.getBamei() + "," + data.getKakuteiChakujun() + "," + data.getKyosomeiHondai());
			}
		}

}
