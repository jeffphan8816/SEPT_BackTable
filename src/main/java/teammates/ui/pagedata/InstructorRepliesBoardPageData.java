/**
 *
 */
package teammates.ui.pagedata;

import java.util.ArrayList;
import java.util.List;
import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.Const;
import teammates.ui.template.ElementTag;
import teammates.ui.template.RepliesDiv;
/**
 * Page data for Instructor replies board
 */

public class InstructorRepliesBoardPageData extends PageData {
    /*
     * Variable Declarations
     */
    public TopicAttributes topic;
    public ArrayList<RepliesDiv> replies;
    public Integer count;
    public Integer viewcount;

    //GETTERS & SETTERS
      public Integer getViewcount() {
          return viewcount;
      }

      public void setViewcount(Integer viewcount) {
          this.viewcount = viewcount;
      }

      public void setTopic(TopicAttributes topic) {
          this.topic = topic;
      }

      public void setReplies(ArrayList<RepliesDiv> replies) {
          this.replies = replies;
      }

      public Integer getCount() {
          return count;
      }

      public void setCount(Integer count) {
          this.count = count;
      }
      public ArrayList<RepliesDiv> getReplies()
      {
          return replies;
      }

      public String getDesc() {
          return topic.getDesc();
      }

      public String getName() {
          return topic.getName();
      }

        public String getID() {
            return topic.getId();
        }


        public TopicAttributes getTopic() {
            return topic;
        }


      //Constructor
      public InstructorRepliesBoardPageData(AccountAttributes account, String sessionToken) {
      super(account, sessionToken);
    }

    //init method for page data
    public void init(TopicAttributes topic) {
        this.topic = topic;
        if(topic.getReplies() != null)
        {
            replies = new ArrayList<RepliesDiv>();
            convertReplies(topic.getReplies());
        }
        this.count = topic.getCount();
        this.viewcount = topic.getViewCounter();

    }

      //Convert replies to repliesDiv in order to display correctly on page (with buttons)
      private void convertReplies(List<RepliesAttributes> replies) {
          for (RepliesAttributes reply : replies) {
              
            List<ElementTag> actionsParam = new ArrayList<>();
            ElementTag editButton = createButton("Edit", "btn btn-xs btn-default reply_edit",
                                                 getInstructorReplyBoardEditLink(topic.getId(), reply.getId().toString()),
                                                 Const.Tooltips.REPLY_EDIT, false);

            actionsParam.add(editButton);

            this.replies.add(new RepliesDiv(reply.getStudent(), reply.getId().toString(), reply.getDesc(), actionsParam, reply.getDateTime(),reply.getLike(),reply.getDislike()));

          }
      }
      //method for creating button
      private ElementTag createButton(String content, String buttonClass, String href, String title,
              boolean isDisabled) {
          ElementTag button = new ElementTag(content);

          button.setAttribute("class", buttonClass);

          if (href != null && !href.isEmpty()) {
          button.setAttribute("href", href);
          }

          if (title != null && !title.isEmpty()) {
          button.setAttribute("title", title);
          button.setAttribute("data-toggle", "tooltip");
          button.setAttribute("data-placement", "top");
          }

          if (isDisabled) {
          button.setAttribute("disabled", null);
          }
          return button;
      }

}
