package edu.pnu.board.persistence;

import org.springframework.data.repository.CrudRepository;

import edu.pnu.board.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
