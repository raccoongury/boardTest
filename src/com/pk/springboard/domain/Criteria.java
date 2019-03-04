package com.pk.springboard.domain;

public class Criteria {

	//현재 페이지 번호
	private int page;
	//페이지 당 출력할 데이터 개수
	private int perPageNum;
	//현재 페이지 번호에 해당하는 데이터의 시작 번호
	private int pageStart;
	
	//현재 페이지 번호는 기본값은 1
		//페이지 당 데이터 출력 개수는 기본값은 10 
		public Criteria() {
			this.page = 1;
			this.perPageNum = 10;
		}

		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}

		public int getPerPageNum() {
			return this.perPageNum;
		}
		
		public void setPerPageNum(int perPageNum) {
			this.perPageNum = perPageNum;
		}
		
		
		//페이지 번호를 가지고 시작하는 데이터 번호를 계산해서 리턴해주는 메소드
		//직접 현재 페이지의 시작 데이터 번호는 계산을 수행해서 리턴합니다.
		public int getPageStart() {
			pageStart = (page - 1) * perPageNum + 1;
			return pageStart;
		}
		
		@Override
		public String toString() {
			return "Criteria [page=" + page + ", " + "perPageNum=" + perPageNum + "]";
		}
	}
