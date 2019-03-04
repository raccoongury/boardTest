package com.pk.springboard.domain;

public class PageMaker {
	// 전체 데이터 개수 - 전체 데이터 개수를 알아야 페이지 번호를 어디까지 출력할 것인지 판단
	private int totalCount;
	// 시작 페이지 번호 - 페이지 번호를 출력할 때 시작하는 페이지 번호
	private int startPage;
	// 종료 페이지 번호 - 페이지 번호를 출력할 때 종료하는 페이지 번호
	private int endPage;
	// 이전 페이지 링크 여부 - 시작하는 페이지 번호가 1이 아닐 때 이전 페이지로 이동할 수 있는 링크 출력 여부
	private boolean prev;
	// 다음 페이지 링크 여부 - 종료 페이지 번호가 전체 페이지 번호가 아닐 때 다음 페이지로 이동할 수 있는 링크 출력 여부
	private boolean next;

	// 페이지 번호 출력 개수
	private int displayPageNum = 10;

	//이전에 설정된 옵션 값을 가지고 다니기 위한 데이터
	private Criteria cri;

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	
	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		calcData();
	}

	
	// 계산을 위한 메소드
	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
}
