package com.jt.lawfirm.mapper.approval;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface IApprovalMapper {
	//案件审批流程
	@Select("select ifnull("
			+ "(select approval_flow_id from approval_law al inner join case_law cl on al.law_id = cl.id "
			+"inner join system_approval_flow saf on al.approval_flow_id = saf.id "
			+"inner join system_user su on su.id = saf.user_id where user_name = #{username} and law_id = #{lawId}),0)"
			)
	int username(@Param("username")String username,@Param("lawId")Integer lawId);
	
	@Update("update approval_law set approval_status = #{approvalStaus} where approval_flow_id = #{id} and law_id = #{law_id}")
	int approvallawone(@Param("approvalStaus")String approvalStaus, @Param("id")Integer id, @Param("law_id")Integer law_id);
	
	@Select("select approval_status from approval_law where approval_flow_id = #{approval_flow_id} and law_id = #{law_id}")
	String statusSel(@Param("approval_flow_id")Integer id, @Param("law_id")Integer law_id);
	
	@Update("update approval_law set approval_status = #{approvalStaus} where approval_flow_id = #{approval_flow_id} and law_id = #{law_id}")
	int approvalLawtwo(@Param("approvalStaus")String approvalStaus,@Param("approval_flow_id")Integer id, @Param("law_id")Integer law_id);
	
	@Update("update case_law set case_approve_status = #{staus} where id = #{id}")
	int approvallaw(@Param("staus")String approvalStaus,@Param("id")Integer law_id);
	
	//用印审批流程
	//查看审批人是否可以审批 返回审批人ID
		@Select("select ifnull("
				+ "(select approval_flow_id from approval_seal al inner join case_seal_applyfor cl on al.seal_id = cl.id "
				+"inner join system_approval_flow saf on al.approval_flow_id = saf.id "
				+"inner join system_user su on su.id = saf.user_id where user_name = #{username} and seal_id = #{seal_id}),0)"
				)
		int usernameseal(@Param("username")String username,@Param("seal_id")Integer seal_id);
		//审批一级通过修改状态
		@Update("update approval_seal set approval_status = #{approvalStaus} where approval_flow_id = #{id} and seal_id = #{seal_id}")
		int approvalsealone(@Param("approvalStaus")String approvalStaus, @Param("id")Integer id, @Param("seal_id")Integer seal_id);
		//查看一级审批通过状态
		@Select("select approval_status from approval_seal where approval_flow_id = #{approval_flow_id} and seal_id = #{seal_id}")
		String sealstatusSel(@Param("approval_flow_id")Integer id, @Param("seal_id")Integer seal_id);
		//审批二级通过修改状态
		@Update("update approval_seal set approval_status = #{approvalStaus} where approval_flow_id = #{approval_flow_id} and seal_id = #{seal_id}")
		int approvalsealtwo(@Param("approvalStaus")String approvalStaus,@Param("approval_flow_id")Integer id, @Param("seal_id")Integer seal_id);
		//全通过后修改用印状态
		@Update("update case_seal_applyfor set applyfor_approval_status = #{staus} where id = #{id}")
		int approvalseal(@Param("staus")String approvalStaus,@Param("id")Integer seal_id);

		//结案审批流程
		//查看审批人是否可以审批 返回审批人ID
			@Select("select ifnull("
					+ "(select approval_flow_id from approval_settle al inner join case_settle cl on al.settle_id = cl.id "
					+"inner join system_approval_flow saf on al.approval_flow_id = saf.id "
					+"inner join system_user su on su.id = saf.user_id where user_name = #{username} and settle_id = #{settle_id}),0)"
					)
			int usernamesettle(@Param("username")String username,@Param("settle_id")Integer settle_id);
			
			@Update("update approval_settle set approval_status = #{approvalStaus} where approval_flow_id = #{id} and settle_id = #{settle_id}")
			int approvalsettleone(@Param("approvalStaus")String approvalStaus, @Param("id")Integer id, @Param("settle_id")Integer settle_id);
			
			@Select("select approval_status from approval_settle where approval_flow_id = #{approval_flow_id} and settle_id = #{settle_id}")
			String settlestatusSel(@Param("approval_flow_id")Integer id, @Param("settle_id")Integer settle_id);
			
			@Update("update approval_settle set approval_status = #{approvalStaus} where approval_flow_id = #{approval_flow_id} and settle_id = #{settle_id}")
			int approvalsettletwo(@Param("approvalStaus")String approvalStaus,@Param("approval_flow_id")Integer id, @Param("settle_id")Integer settle_id);
			
			@Update("update case_settle set status = #{staus} where id = #{id}")
			int approvalsettle(@Param("staus")String approvalStaus,@Param("id")Integer settle_id);
			//修改结案的审批人
			@Update("update case_settle set settle_proposer = #{settle_proposer} where id = #{settle_id}")
			int updatesettle(@Param("applyfor_recipient")String string, @Param("refund_id")Integer settle_id);
			
			
		//退费审批
			//查看审批人是否可以审批 返回审批人ID
				@Select("select ifnull((select ifnull(approval_flow_id,0) from approval_refund al inner join case_refund cl on al.refund_id = cl.id "
						+"inner join system_approval_flow saf on al.approval_flow_id = saf.id "
						+"inner join system_user su on su.id = saf.user_id where user_name = #{username} and refund_id = #{refund_id}),0)"
						)
				int usernamerefund(@Param("username")String username,@Param("refund_id")Integer refund_id);
				//审批一级通过修改状态
				@Update("update approval_refund set approval_status = #{approvalStaus} where approval_flow_id = #{id} and refund_id = #{refund_id}")
				int approvalrefundone(@Param("approvalStaus")String approvalStaus, @Param("id")Integer id, @Param("refund_id")Integer refund_id);
				//查看一级审批通过状态
				@Select("select approval_status from approval_refund where approval_flow_id = #{approval_flow_id} and refund_id = #{refund_id}")
				String refundstatusSel(@Param("approval_flow_id")Integer id, @Param("refund_id")Integer refund_id);
				//审批二级通过修改状态
				@Update("update approval_refund set approval_status = #{approvalStaus} where approval_flow_id = #{approval_flow_id} and refund_id = #{refund_id}")
				int approvalrefundtwo(@Param("approvalStaus")String approvalStaus,@Param("approval_flow_id")Integer id, @Param("refund_id")Integer refund_id);
				//全通过后修改用印状态
				@Update("update case_refund set case_refund_status = #{staus} where id = #{id}")
				int approvalrefund(@Param("staus")String approvalStaus,@Param("id")Integer refund_id);
				//修改退费的审批人
				@Update("update case_refund set case_proposer = #{case_proposer} where id = #{refund_id}")
				int updaterefund(@Param("applyfor_recipient")String string, @Param("refund_id")Integer refund_id);
				
				//费用减免审批
				//查看审批人是否可以审批 返回审批人ID
					@Select("select ifnull("
							+ "(select approval_flow_id from approval_relief al inner join case_cost_relief cl on al.relief_id = cl.id "
							+"inner join system_approval_flow saf on al.approval_flow_id = saf.id "
							+"inner join system_user su on su.id = saf.user_id where user_name = #{username} and relief_id = #{relief_id}),0)"
							)
					int usernamerelief(@Param("username")String username,@Param("relief_id")Integer relief_id);
					//审批一级通过修改状态
					@Update("update approval_relief set approval_status = #{approvalStaus} where approval_flow_id = #{id} and relief_id = #{relief_id}")
					int approvalreliefone(@Param("approvalStaus")String approvalStaus, @Param("id")Integer id, @Param("relief_id")Integer relief_id);
					//查看一级审批通过状态
					@Select("select approval_status from approval_relief where approval_flow_id = #{approval_flow_id} and relief_id = #{relief_id}")
					String reliefstatusSel(@Param("approval_flow_id")Integer id, @Param("relief_id")Integer relief_id);
					//审批二级通过修改状态
					@Update("update approval_relief set approval_status = #{approvalStaus} where approval_flow_id = #{approval_flow_id} and relief_id = #{relief_id}")
					int approvalrelieftwo(@Param("approvalStaus")String approvalStaus,@Param("approval_flow_id")Integer id, @Param("relief_id")Integer relief_id);
					//全通过后修改用印状态
					@Update("update case_cost_relief set relief_approval_status = #{staus} where id = #{id}")
					int approvalrelief(@Param("staus")String approvalStaus,@Param("id")Integer relief_id);
					//修改用印的审批人
					@Update("update case_seal_applyfor set applyfor_recipient = #{applyfor_recipient} where id = #{seal_id}")
					int updateSeal(@Param("applyfor_recipient")String string, @Param("seal_id")Integer seal_id);
				
				
}
